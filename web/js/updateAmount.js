$(function() {

	setInterval(updateAmount, 3000);

	function updateAmount() {

		$.get('AccountServlet').done(processAmountResult);
	}

	function processAmountResult(data) {

		data = JSON.parse(data);

		$('#amount').text(data.currentAmount);

	}

})