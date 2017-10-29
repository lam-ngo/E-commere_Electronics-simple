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
	console.log("Done");
	$.ajax ({ 
		url: '/cart/total', 
		type: "GET", 
		dataType: "json",
		contentType: "application/json",
		complete: function(responseData, status, xhttp){ 
			$('#cart-total').text('('+responseData.responseJSON+')');
		}
	});
	
}