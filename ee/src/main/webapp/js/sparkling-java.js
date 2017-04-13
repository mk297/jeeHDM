function insertInitialPlacments(data) {
	alert(data);
}


$.get("localhost:9990/management/booking", insertInitialPlacments);