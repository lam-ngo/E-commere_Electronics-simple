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
				$('#signup-or-account').text('Sign Up');
				$('#login-or-logout').text('Login');
				//change hyperlink
				$('#signup-or-account').attr("href","/signup");
				$('#login-or-logout').attr("href","/login");
				
				//<span class="glyphicon glyphicon-user"></span>
				//<span class="glyphicon glyphicon-log-in"></span>
			}else{
				console.log("isLogin");
				//change text 
				$('#signup-or-account').text('My account');
				$('#login-or-logout').text('Logout');
				//change hyperlink
				$('#signup-or-account').attr("href","/account");
				$('#login-or-logout').attr("href","/logout");
			}
			
		}
	});
}