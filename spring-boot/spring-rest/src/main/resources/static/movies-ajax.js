function getAllMovies() {
    var tableBody = $('#movies-list');

    $.get({
        url: 'http://localhost:8080/movies',
        success: function (movies) {
            for (var i = 0; i < movies.length; i++) {
                var movie = movies[i];
                var row = $('<tr id=\"movie-row' + movie.id + '\"></tr>');

                row.append('<td>' + movie.id + '</td>');
                row.append('<td>' + movie.name + '</td>');
                row.append('<td>' +
                    '<form action="#">' +
                    '<button type="button" value="Detail" onclick="getMovieDetail(' + movie.id + ')">Detail</button>' +
                    '</form>' +
                    '</td>');

                tableBody.append(row);
            }
        }
    });
}

function getMovieDetail(movieId) {
    var movieDetail = $('#movie-detail');

    $.get({
        url: 'http://localhost:8080/movies/' + movieId,
        success: function (movie) {
            movieDetail.find('#movie-id').val(movie.id);
            movieDetail.find('#movie-name').val(movie.name);
        }
    });
}

function addNewMovie() {
    var movie = {name: $('#add-movie').find("#name").val()};

    $.post({
        url: 'http://localhost:8080/movies',
        data: JSON.stringify(movie),
        contentType: 'application/json',
        success: function () {
            getAllMovies();
        }
    });
}

