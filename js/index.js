$(document).ready(function(){
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
            },
            error: function(data) {
              console.log(data);
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
 
