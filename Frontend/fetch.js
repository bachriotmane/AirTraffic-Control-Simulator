function getData(link) {
    fetch(link)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            console.log("Hi");
        })
        .catch(error => console.error('Error:', error));
}
getData("http://localhost:8080/api")
console.log("jjjlk");

function addAirport() {
    const nom = document.getElementById("nom").value;
    const nbrPiste = document.getElementById("nbrPiste").value;
    const nbrPlaceSol = document.getElementById("nbrPlaceSol").value;
    const tempsAccessPiste = document.getElementById("tempsAccessPiste").value;
    const delaiAntCollision = document.getElementById("delaiAntCollision").value;
    const tempsDecolage = document.getElementById("tempsDecolage").value;
    const durreeBoucleDattent = document.getElementById("durreeBoucleDattent").value;
    const delaiAuSol = document.getElementById("delaiAuSol").value;
    const working = document.getElementById("working").checked;

    const newAirport = {
        nom: nom,
        nbrPiste: nbrPiste,
        nbrPlaceSol: nbrPlaceSol,
        tempsAccessPiste: tempsAccessPiste,
        delaiAntCollision: delaiAntCollision,
        tempsDecolage: tempsDecolage,
        durreeBoucleDattent: durreeBoucleDattent,
        delaiAuSol: delaiAuSol,
        working: working,
    };

    fetch("/api/airoports", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newAirport),
    })
        .then(response => response.json())
        .then(data => {
            getAirportsData(); // Refresh the table with the updated data
        })
        .catch(error => console.error('Error:', error));
}