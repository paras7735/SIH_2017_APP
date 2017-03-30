$(document).ready(function(){
function dbupdate() {
  $.ajax({
    type: "POST",
    url: "controller/dbupdate.php",
    success: function(data) {
      arr=jQuery.parseJSON(data);
      console.log(arr);
      var nodes = {};

      for (var i = 1; i <=arr.length; ++i) {
          nodes[i-1] = { "Id": arr[i-1].id, level: arr[i-1].level, level_index:arr[i-1].level_index , quality:arr[i-1].quality , quantity:arr[i-1].quantity , parent:arr[i-1].parent 
      , is_home:arr[i-1].is_home, updated_at:arr[i-1].updated_at, "userId":arr[i-1].userId  }
      }
      theft(nodes,arr.length);
      qualitydrop(nodes,arr.length);
    },
    error: function(result) {
      console.log('kjbklj');
    }  
    });
  };
  dbupdate();

  function theft(nodes,length){
  var sum,i,j;
  var m=0;
  var nodes2 = {};
  var parentids= [];
  for(i=0;i<length;i++){
    sum=0;
    if(parentids.indexOf(nodes[i]["parent"])==-1){
      parentids[m++]=nodes[i]["parent"];
      for(j=0;j<length;j++){
        if(nodes[i]["parent"]==nodes[j]["parent"]){
          sum=parseInt(sum)+parseInt(nodes[j]["quantity"]);
        }
      }
      nodes2[m]={"parent":nodes[i]["parent"],"sum":sum}

    }
  }
  for(var k=1;k<m+1;k++){
    i=nodes2[k]['parent'];
    if(i!=-1){
      console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[i]['quantity']);
      if(nodes2[k]['sum']!=nodes[i]['quantity']){
        
    // msg[i] = { "id":i}
    //the i here will give the id of the meter after which there is a leakage

        console.log("please check line after meter with id:-"+i);
      }
    }else{
console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quantity'])
      //console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quantity'])
    }
  }
  //console.log("after for loop");

  }


    function qualitydrop(nodes,length){
  var sum,i,j;
  var m=0;
  var nodes2 = {};
  var parentids= [];
  for(i=0;i<length;i++){
    sum=0;
    if(parentids.indexOf(nodes[i]["parent"])==-1){
      parentids[m++]=nodes[i]["parent"];
      for(j=0;j<length;j++){
        if(nodes[i]["parent"]==nodes[j]["parent"]){
          sum=parseInt(sum)+parseInt(nodes[j]["quality"]);
        }
      }
      nodes2[m]={"parent":nodes[i]["parent"],"sum":sum}

    }
  }
  for(var k=1;k<m+1;k++){
    i=nodes2[k]['parent'];
    if(i!=-1){
      console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[i]['quality']);
      if(nodes2[k]['sum']!=nodes[i]['quality']){
        
    //msg2[i] = { "id":i}
        //the i here will give the id of the meter after which there is a leakage

        console.log("please check line after meter with id:-"+i);
      }
    }else{
 console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quality'])
      console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quality'])
    }
  }
  //console.log("after for loop");
  }


});