$(function() {

	$('#transferBtn').click(transfer);

	function transfer() {

		var password = $('#password').val();
		var amount = $('#amount').val();
		var targetAccountNo = $('#targetAccountNo').val();

		$.post('TransferServlet', {
			password : password,
			amount : amount,
			targetAccountNo : targetAccountNo
		}).done(processTransferResult);
	}

	function processTransferResult(data) {

		try {

			data = JSON.parse(data);

			$('#successDiv').show();
			$('#accountNumber').text(data.accountNumber);
			$('#currentAmount').text(data.currentAmount);
		} catch (err) {
			$("html").html(data);
		}

	}

})