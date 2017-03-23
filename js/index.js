$(document).ready(function(){

  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyBZ1nKewxNC_s53gyd-KSdB7gWseVf1Xmg",
    authDomain: "sihfinalsiitkgp-5e9c0.firebaseapp.com",
    databaseURL: "https://sihfinalsiitkgp-5e9c0.firebaseio.com",
    storageBucket: "sihfinalsiitkgp-5e9c0.appspot.com",
    messagingSenderId: "1027182829065"
  };
  firebase.initializeApp(config);


 
  console.log(firebase);
  $("#submit").click(function(){
        uname = $("#uname").val();
        pass = $("#pass").val();
   
   $.ajax({
            type: "POST",
            url: "controller/login.php",
            data: {
                uname:uname,
                pass:pass
            },
            dataType: "JSON",
            success: function(data) {
            	console.log(data);
            window.location.assign('index.php');
        },
  		error: function(data) {
                        console.log(data);
                    }    });
   });
  var arr;
 
  
    function dbupdate() {
    $.ajax({
            type: "POST",
            url: "controller/dbupdate.php",
            success: function(data) {
              arr=jQuery.parseJSON(data);
             var playersRef = firebase.database().ref("table/");

  var nodes = {};

for (var i = 1; i <=arr.length; ++i) {
    nodes[i-1] = { "Id": arr[i-1].id, level: arr[i-1].level, level_index:arr[i-1].level_index , quality:arr[i-1].quality , quantity:arr[i-1].quantity , parent:arr[i-1].parent 
, is_home:arr[i-1].is_home, updated_at:arr[i-1].updated_at  }
}
playersRef.set({
   nodes
   });
    theft(nodes,arr.length);
            },
            error: function(result) {
          console.log('kjbklj');
                  }  
                            });
};
  $("#submitread").click(function(){
        level = $("#level").val();
        parent = $("#parent").val();
        level_index = $("#level_index").val();
        home = $("#home").val();
        quality = $("#quality").val();
        quantity = $("#quantity").val();
   $.ajax({
            type: "POST",
            url: "controller/readings.php",
            data: {
                level:level,
                parent:parent,
                level_index:level_index,
                home:home,
                quality:quality,
                quantity:quantity
            },
            dataType: "JSON",
            success: function(data) {
              
              console.log(data);
              Materialize.toast('Data Updated', 5000);
              $("#form1").trigger("reset");
              dbupdate();
          
            },
            error: function(response) {
              
            }  
          });
   });
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
});
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
        //the i here will give the id of the meter after which there is a leakage

        console.log("please check line after meter with id:-"+i);
      }
    }else{
      console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[0]['quantity'])
    }
  }
  console.log("after for loop");
}

