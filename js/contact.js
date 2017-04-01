$(document).ready(function(){
	$.ajax({
		type: "POST",
            url: "controller/contactlist.php",
            success: function(data) {
              arr=jQuery.parseJSON(data);
              // console.log(arr);
              var nodes = {};

		      for (var i = 1; i <=arr.length; ++i) {
		          nodes[i-1] = { meter_id: arr[i-1].meter_id, name: arr[i-1].name, email:arr[i-1].email , address:arr[i-1].address , contact:arr[i-1].contact}
		      }
		      // console.log(nodes);
		      var i,string;
			    var m=0;
			    var nodes2 = {};
			    for(i=0;i<arr.length;i++){
			          nodes2[m]={"meter_id":nodes[i]["meter_id"],"name":nodes[i]["name"],"email":nodes[i]["email"],"address":nodes[i]["address"],"contact":nodes[i]["contact"]};
			          console.log(nodes2[m]);
			          m++;
			          string+="<tr><td>"+nodes[i]["meter_id"]+"</td><td>"+nodes[i]["name"]+"</td><td>"+nodes[i]["email"]+"</td><td>"+nodes[i]["address"]+"</td><td>"+nodes[i]["contact"]+"</td></tr>"
			    }
			    $('#tableBody').html(string);
            },
            error: function(data) {
              console.log(data);
            } 
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