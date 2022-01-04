class ImdbViewModel {
	constructor() {
		this.genres = ko.observableArray([]);
		this.genre = ko.observable();
		this.movies = ko.observableArray([]);
	}

	init = () => {
		fetch("http://localhost:8100/imdb/api/v1/genres", {
			headers: {
				"Accept": "application/json"
			}
		})
		.then(res => res.json())
		.then(genres => {
			genres.sort((left, right) => left.name.localeCompare(right.name));
			this.genres(genres);
		});
	}

	search = () => {
		fetch(`http://localhost:8100/imdb/api/v1/movies?genre=${this.genre().name}`, {
			headers: {
				"Accept": "application/json"
			}
		})
		.then(res => res.json())
		.then(movies => {
			movies.sort((left, right) => left.year - right.year);
			this.movies(movies);
		});
	}
}

let imdbViewModel = new ImdbViewModel();

window.onload = () => {
	ko.applyBindings(imdbViewModel);
	imdbViewModel.init();
}