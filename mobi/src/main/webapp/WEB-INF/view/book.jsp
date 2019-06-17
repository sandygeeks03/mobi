<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Book</title>

<style>
/* Style all input fields */
input {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
}

/* Style the submit button */
input[type=submit] {
  background-color: #4CAF50;
  color: white;
}

/* Style the container for inputs */
.container {
  background-color: #f1f1f1;
  padding: 20px;
}

.h11{
margin-left: 50px;
}

.hs{
 text-align: right;
 margin-right: 50px;
}



</style>

</head>
<body>
	
<h3 class="h11"> Book Rooms</h3>
<div>
<h4 class="h11">Total rooms available:${room.rooms}</h4>
<h5 class="h11">Availability:${room.status}</h5>
</div>

<div class="container">
  <form action="" method="POST" >
  <div class="form-group">
    <label for="roomname">Room Name</label>
    <input type="text" id="roomname" name="roomname" Placeholder="Room-1" value="room-one" disabled>
    <input type="hidden" id="roomid" name="roomid" value="1">
  </div>
  <div class="form-group">
    <label for="num">Number of rooms</label>
    <input type="number" id="nrooms" name="nrooms"  title="Must book only ten rooms at a time" max="10"required>
  </div>  
    <input type="submit" onclick="foo();" value="Book">
  </form>
</div>
	
	
<script>
function foo() {
	   var roomid = document.getElementById('roomid').value;
	   var numberofrooms = document.getElementById('nrooms').value;
	   $.ajax({
	        type: "POST",
	        traditional: true,
	        url: "/save",
	        data: {
	        	roomid: roomid,
	        	reqrooms: numberofrooms
	          },
	        success: function (data) {
	           alert(data);
	        },
	        error: function (result) {
	          alert("oops");
	        }
	      });

	}
</script>
	
</body>
</html>