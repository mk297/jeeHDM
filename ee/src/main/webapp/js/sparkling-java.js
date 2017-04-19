function deletePerson() {
	$.post( 'rest/booking/deletePerson', { personID: $('#personID').val() })
    .done(function( data ) {
        alert( 'Successfull: ' + data.success );
        location.reload();
      });
	event.preventDefault();
}

function createPerson() {
	$.post( 'rest/booking/createPerson', { preName: $('#preName').val(),surName: $('#surName').val() })
    .done(function( data ) {
        alert( 'Successfull: ' + data.success );
        location.reload();
      });
	event.preventDefault();
}

function bookSeat() {
	$.post( 'rest/booking/deletePerson', { personID: $('#personID').val() })
    .done(function( data ) {
        alert( 'Successfull: ' + data.success );
        location.reload();
      });
	event.preventDefault();
}