$(document).ready(function(){
 var config = {
    apiKey: "AIzaSyBZ1nKewxNC_s53gyd-KSdB7gWseVf1Xmg",
    authDomain: "sihfinalsiitkgp-5e9c0.firebaseapp.com",
    databaseURL: "https://sihfinalsiitkgp-5e9c0.firebaseio.com",
    storageBucket: "sihfinalsiitkgp-5e9c0.appspot.com",
    messagingSenderId: "1027182829065"
  };
  firebase.initializeApp(config);
 var k={};
 var string='';
  console.log(firebase);
  var ref = firebase.database().ref("/complaints");

ref.on("value", function(snapshot) {
  string='';
  var arr=snapshot.val();

 var size = 0, key;
    for (key in arr) {
        if (arr.hasOwnProperty(key)) {k[size]=key;size++;}


    }
    // console.log(arr[k[0]]);
    // console.log(arr[k[1]]);
   for (var i = 0; i < size; i++) {
     string+="<tr><td>"+arr[k[i]]['contact']+"</td><td>"+arr[k[i]]['email']+"</td><td>"+arr[k[i]]['message']+"</td><td>"+arr[k[i]]['type']+"</td></tr>";
   }
   $('#tableBody7').html(string);
}, function (error) {
   console.log("Error: " + error.code);
});

$(function() {
  $('#quali').hover(function() {
    $('#quali_bubble').css('opacity', '1');
  }, function() {
    // on mouseout, reset the background colour
    $('#quali_bubble').css('opacity', '0');
  });
});
$(function() {
  $('#quant').hover(function() {
    $('#quant_bubble').css('opacity', '1');
  }, function() {
    // on mouseout, reset the background colour
    $('#quant_bubble').css('opacity', '0');
  });
});
$(function() {
  $('#click-toggle-circle').hover(function() {
    $('#node6').css('opacity', '1');
  }, function() {
    // on mouseout, reset the background colour
    $('#node6').css('opacity', '0');
  });
});


$(".button-collapse").sideNav();

   $('.button-collapse').sideNav({
      menuWidth: 1050, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens
    }
  );

function dbupdate() {
    var ref2 = firebase.database().ref("/table/nodes");
var m=0,string3;
var nodes2 = {};

ref2.on("value", function(snapshot) {
  string='';
  var nodes=snapshot.val();
// console.log(nodes[0]);
    for(var i=0;i<nodes.length;i++){
          quality5=parseFloat(nodes[i]["quality"]);
          nodes2[m]={"parent":nodes[i]["parent"],"quality":quality5,"id":parseInt(nodes[i]["Id"])};
          m++;
          // console.log(nodes2[i]);
    }
    for(var k=1;k<m;k++){
      i=-1;
      i=nodes2[k]['parent'];
      // console.log(i);
     string3='';
      if(i!=-1){
         qual_parent=parseFloat(nodes[i]["quality"]);
        if(nodes2[k]['quality']!=qual_parent){
          hid=nodes2[k]['id'];
          qual2=nodes2[k]['quality'];
          string3 += "<tr><td>"+i+"</td><td>"+hid+"</td><td>"+qual2+"</td></tr>";
        }
      }
    }
    $('#tableBody').html(string3);

}, function (error) {
   console.log("Error: " + error.code);
});

  $.ajax({
    type: "POST",
    url: "controller/dbupdate.php",
    success: function(data) {
      arr=jQuery.parseJSON(data);
      // console.log(arr);
      var nodes = {};

      for (var i = 1; i <=arr.length; ++i) {
          nodes[i-1] = { id: arr[i-1].id, level: arr[i-1].level, level_index:arr[i-1].level_index , quality:arr[i-1].quality , quantity:arr[i-1].quantity , parent:arr[i-1].parent 
      , is_home:arr[i-1].is_home, updated_at:arr[i-1].updated_at, userId:arr[i-1].userId  }
      }
      
      // var response=qualitydrop_home(nodes,arr.length);
      // $('#tableBody').html(response);
      var response2=[];
      response2=theft(nodes,arr.length);
      console.log(response2);
      $('#tableBody2').html(response2.join(""));
      // $('#tableBody2').html(response2);
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
  var n=1;
  var array_faulty=[];
  for(var k=1;k<m+1;k++){

    i=nodes2[k]['parent'];
    if(i!=-1){
      var sum=0;
      // console.log(i+"--"+nodes2[k]['sum']+"--"+nodes[i]['quantity']);
      if(nodes2[k]['sum']!=nodes[i]['quantity']){
        diff=(-parseInt(nodes2[k]['sum'])+parseInt(nodes[i]['quantity']));
        if(parseInt(diff)<0){
          console.log(diff);
          var par=nodes[i]['parent'];
          console.log(par);
          for (var z = 0; z < length; z++) {
            if(parseInt(nodes[z]['id'])==parseInt(par)){

              var par_data=parseInt(nodes[z]['quantity']);
              console.log(par_data);
            }
            if(parseInt(nodes[z]['parent'])==parseInt(par)){
              sum+=parseInt(nodes[z]['quantity']);
            }
          }
          var abc=parseInt(sum)-parseInt(diff);
          console.log(sum);
          console.log(abc);
          if(parseInt(abc)==parseInt(par_data)){
            console.log("Meter is faulty "+nodes[i]['id']);
            string2="<tr><td>Meter "+nodes[i]['id']+" is faulty.</td><td></td></tr>";
            array_faulty.pop();
            array_faulty.push(string2);
            continue;
          }
          
        }
        if(parseInt(diff)>0){
          console.log(diff);
          var par=nodes[i]['parent'];
          console.log(par);
          for (var z = 0; z < length; z++) {
            if(parseInt(nodes[z]['id'])==parseInt(par)){

              var par_data=parseInt(nodes[z]['quantity']);
              console.log(par_data);
            }
            if(parseInt(nodes[z]['parent'])==parseInt(par)){
              sum+=parseInt(nodes[z]['quantity']);
            }
          }
          var abc=parseInt(sum)+parseInt(diff);
          console.log(sum);
          console.log(abc);
          if(parseInt(abc)==parseInt(par_data)){
            console.log("Meter is faulty "+nodes[i]['id']);
            string2="<tr><td>Meter "+nodes[i]['id']+" is faulty.</td><td></td></tr>";
            array_faulty.pop();
            array_faulty.push(string2);
            continue;
          }
          
        }

        string2 = "<tr><td>"+i+"</td><td>"+diff+"</td></tr>";
        array_faulty.push(string2);
      }
    }else{
    }
  }
  //console.log("after for loop");
  return array_faulty;
  }


function qualitydrop_home(nodes,length){
  var sum,i,j,quality,string;
  var m=0;
  var nodes2 = {};
  for(i=0;i<length;i++){
      quality=parseFloat(nodes[i]["quality"]);
      is_home=nodes[i]["is_home"];
      if (is_home==1) {
        if(parseFloat(quality)>8 || parseFloat(quality)<6){
        nodes2[m]={"parent":nodes[i]["parent"],"quality":quality,"id":nodes[i]["id"]};
        // console.log(nodes2[m]);
        m++;
      }
    }
  }
  for(var k=0;k<m;k++){
         i=nodes2[k]['parent'];
         hid=nodes2[k]['id'];
         qual=parseFloat(nodes2[k]['quality']);
         // console.log("Please check line after meter with id(quality load):-"+i+" in the house ID: "+hid);
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

  $('.modal').modal();
  // $('#modal1').modal('open');
  $('.modal').modal({
      dismissible: true, // Modal can be dismissed by clicking outside of the modal
      opacity: .5, // Opacity of modal background
      inDuration: 300, // Transition in duration
      outDuration: 200, // Transition out duration
      startingTop: '4%', // Starting top style attribute
      endingTop: '10%', // Ending top style attribute
      ready: function(modal, trigger) { // Callback for Modal open. Modal and trigger parameters available.
        // alert("Ready");
        // console.log(modal, trigger);
      },
      // complete: function() { alert('Closed'); } // Callback for Modal close
    }
  );




});

