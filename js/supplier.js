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
          nodes[i-1] = { id: arr[i-1].id, level: arr[i-1].level, level_index:arr[i-1].level_index , quality:arr[i-1].quality , quantity:arr[i-1].quantity , parent:arr[i-1].parent 
      , is_home:arr[i-1].is_home, updated_at:arr[i-1].updated_at, userId:arr[i-1].userId  }
      }
      
      var response=qualitydrop(nodes,arr.length);
      $('#tableBody').html(response);
      var response2=theft(nodes,arr.length);
      $('#tableBody2').html(response2);
    },
    error: function(result) {
      console.log('kjbklj');
    }  
    });
  };
  dbupdate();

  function theft(nodes,length){
  var sum,i,j,string2,diff;
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
        diff=(-parseInt(nodes2[k]['sum'])+parseInt(nodes[i]['quantity']));
    // msg[i] = { "id":i}
    //the i here will give the id of the meter after which there is a leakage

        console.log("please check line after meter with id(theft):-"+i);
        string2 += "<tr><td>"+i+"</td><td>"+diff+"</td></tr>";
      }
    }else{
      console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quantity'])
      console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quantity'])
    }
  }
  //console.log("after for loop");
  return string2;
  }


function qualitydrop(nodes,length){
  var sum,i,j,quality,string;
  var m=0;
  var nodes2 = {};
  for(i=0;i<length;i++){
      quality=parseFloat(nodes[i]["quality"]);
      if(parseFloat(quality)>8 || parseFloat(quality)<6){
      nodes2[m]={"parent":nodes[i]["parent"],"quality":quality,"id":nodes[i]["id"]};
      console.log(nodes2[m]);
      m++;
    }
      
  }
  for(var k=0;k<m;k++){
         i=nodes2[k]['parent'];
         hid=nodes2[k]['id'];
         qual=parseFloat(nodes2[k]['quality']);
         console.log("Please check line after meter with id(quality load):-"+i+" in the house ID: "+hid);
         string += "<tr><td>"+i+"</td><td>"+hid+"</td><td>"+qual+"</td></tr>";
      
  }
  return string;
  }
  

  $("#lout").click(function(){
   $.ajax({
            type: "POST",
            url: "controller/logout.php",
            success: function(data) {
              console.log(data);
              window.location.assign('index.php');
            },
            error: function(data) {
              console.log(data);
            }    
        });
   });

  $('ul.tabs').tabs();


});