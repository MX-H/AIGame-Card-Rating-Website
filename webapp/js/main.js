function getRandomInt(min, max) {
	min = Math.ceil(min);
	max = Math.floor(max);
	return Math.floor(Math.random() * (max - min + 1) + min);
}

function getRandomCard() {
	let rand_int = getRandomInt(1, 10);
	document.getElementById("card_image").src = "../css/Cards/card" + rand_int + ".jpg";
}

function submitRating() {
	let archetype = document.getElementById('archetype').value;
	let rating = document.getElementById('rating').value;
	let comments = document.getElementById('comments').value;

	const url = 'http://localhost:8080/rating';

	const data = {
		archetype: archetype,
		rating: rating,
		comments: comments
	};

	const options = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(data)
	};

	fetch(url, options)
		.then(response =>response)
		.then(result=>{console.log(result)})
		.catch(error=>console.log(error));

	document.getElementById('archetype').value = "default";
	document.getElementById('rating').value = "default";
	document.getElementById('comments').value = "";

	modal.style.display = "none";
}