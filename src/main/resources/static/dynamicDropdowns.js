$(document).ready(function () {

    // When country dropdown value changes
    $("#country").on("change", function () {
        var countryId = $(this).val();

        // Reset states and cities dropdowns
        $('#state').find('option').remove();
        $('<option>').val('').text('-Select-').appendTo("#state");

        $('#city').find('option').remove();
        $('<option>').val('').text('-Select-').appendTo("#city");

        if (countryId) {
            // Fetch states based on selected country
            $.ajax({
                type: 'GET',
                url: '/api/states?countryId=' + countryId,
                success: function (response) {
                    $.each(response, function (key, value) {
                        $('<option>').val(key).text(value).appendTo("#state");
                    });
                }
            });
        }
    });

    // When state dropdown value changes
    $("#state").on("change", function () {
        var stateId = $(this).val();

        // Reset cities dropdown
        $('#city').find('option').remove();
        $('<option>').val('').text('-Select-').appendTo("#city");

        if (stateId) {
            // Fetch cities based on selected state
            $.ajax({
                type: 'GET',
                url: '/api/cities?stateId=' + stateId,
                success: function (response) {
                    $.each(response, function (key, value) {
                        $('<option>').val(key).text(value).appendTo("#city");
                    });
                }
            });
        }
    });

});
