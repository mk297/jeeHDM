$('#deletePerson').click(function (event) {
	$.post( 'rest/booking/deletePerson', { personID: $('#delPersonID').val() })
    .done(function( data ) {
        alert( 'Successfull: ' + data.success );
        location.reload();
      });
	event.preventDefault();
});

$('#createPerson').click(function (event) {
	$.post( 'rest/booking/createPerson', { preName: $('#preName').val(),surName: $('#surName').val() })
    .done(function( data ) {
        alert( 'Successfull: ' + data.success );
        location.reload();
      });
	event.preventDefault();
});

$('#bookSeat').click(function (event) {
	$.post( 'rest/booking', { personID: $('#personID').val(), seat: $('#seat').val(), row: $('#row').val()})
    .done(function( data ) {
        alert( 'Successfull: ' + data.success );
        location.reload();
      });
	event.preventDefault();
});