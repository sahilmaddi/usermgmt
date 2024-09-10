document.addEventListener('DOMContentLoaded', function () {
    const countrySelect = document.getElementById('countryId');
    const stateSelect = document.getElementById('stateId');
    const citySelect = document.getElementById('cityId');

    // Fetch states when a country is selected
    countrySelect.addEventListener('change', function () {
        const countryId = countrySelect.value;
        if (countryId) {
            fetch(`/api/states?countryId=${countryId}`)
                .then(response => response.json())
                .then(data => {
                    stateSelect.innerHTML = '<option value="">-Select-</option>';
                    Object.entries(data).forEach(([key, value]) => {
                        const option = document.createElement('option');
                        option.value = key;
                        option.text = value;
                        stateSelect.appendChild(option);
                    });
                    citySelect.innerHTML = '<option value="">-Select-</option>';  // Reset city select
                })
                .catch(error => console.error('Error fetching states:', error));
        } else {
            stateSelect.innerHTML = '<option value="">-Select-</option>';
            citySelect.innerHTML = '<option value="">-Select-</option>';
        }
    });

    // Fetch cities when a state is selected
    stateSelect.addEventListener('change', function () {
        const stateId = stateSelect.value;
        if (stateId) {
            fetch(`/api/cities?stateId=${stateId}`)
                .then(response => response.json())
                .then(data => {
                    citySelect.innerHTML = '<option value="">-Select-</option>';
                    Object.entries(data).forEach(([key, value]) => {
                        const option = document.createElement('option');
                        option.value = key;
                        option.text = value;
                        citySelect.appendChild(option);
                    });
                })
                .catch(error => console.error('Error fetching cities:', error));
        } else {
            citySelect.innerHTML = '<option value="">-Select-</option>';
        }
    });
});
