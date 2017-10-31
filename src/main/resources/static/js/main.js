$(document).ready(function(){
	updateCartItemCount();
	checkUserLogin();
});

function addItemToCart(productId){
	$.ajax ({
		url: '/addToCart/' + productId,
		type: "GET",
		dataType: "json",
		contentType: "application/json",
		complete: function(responseData, status, xhttp){
			updateCartItemCount();
		}
	});
	
	/*
	
	$.ajax({url: "http://localhost:8080/addToCart", success: function(result){
		updateCartItemCount();
    }});
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	updateCartItemCount()
	    }
	};
	xhttp.open("GET", "http://localhost:8080/addToCart", true);
	xhttp.send();
	*/
}


function updateCartItemCount(){
	$.ajax ({ 
		url: '/cart/total', 
		type: "GET", 
		dataType: "json",
		contentType: "application/json",
		complete: function(responseData, status, xhttp){ 
			var response = responseData.responseJSON;
			
			if(response.length > 0){
				$('#cart-total').text('('+response.length+')');
			}
			
		}
	});
	
}

function checkUserLogin(){
	$.ajax ({ 
		url: '/isLogin', 
		type: "GET", 
		dataType: "json",
		contentType: "application/json",
		complete: function(responseData, status, xhttp){ 
			var response = responseData.responseJSON;
			console.log(response);
			if(response==false){
				console.log("notLogin");
				//change text 
				$('#signup-or-account').append('<a href="/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a>');
				$('#login-or-logout').append('<a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a>');
	
				//<span class="glyphicon glyphicon-user"></span>
				//<span class="glyphicon glyphicon-log-in"></span>
			}else{
				console.log("isLogin");
				//change text 
				$('#signup-or-account').append('<a href="/userAccount"><span class="glyphicon glyphicon-user"></span> My account</a>');
				$('#login-or-logout').append('<a href="/logoutConfirm"><span class="glyphicon glyphicon-log-out"></span> Logout</a>');
				
			}
			
		}
	});
}