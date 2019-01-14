$(document).ready( function () {
    var table = $('#postupilo').DataTable({
        "sAjaxSource": "/getPostupilo",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "columns": [
            { "Data": "id"},
            { "Data": "val" }
        ]
    })
});