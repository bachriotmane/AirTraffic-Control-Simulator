async function funCall(lien) {

  try {
    const response = await fetch(lien);
    const list = await response.json();

    var airoprts = [];
    list.forEach((item) => {
      const airoport = {
        id: item.idAeroport,
        nom: item.nom,
      };
      airoprts.push(airoport);
    });
    
    const startAirportSelect = document.getElementById('startAirport');
    const finalAirportSelect = document.getElementById('finalAirport');

    airoprts.forEach((airport) => {
      const option = document.createElement('option');
      option.value = airport.id;
      option.text = airport.nom;
      startAirportSelect.add(option.cloneNode(true));
      finalAirportSelect.add(option);
    });
    
  
    startAirportSelect.addEventListener('change', async function (){
      const avionSelect = document.getElementById('avion');
      var selectedAirportId = this.value;
      console.log(selectedAirportId);
      var response = await fetch(`http://localhost:8080/avion/Avionsfree/${selectedAirportId}`); 
      var avionList = await response.json();
      avionList.map((avion) =>{
        const option = document.createElement("option");
        option.setAttribute("id",avion.id_avion);
        option.innerText=getConcatenatedName(avion);
        avionSelect.appendChild(option);

      });
      console.log(avionList);
  });
    return airoprts;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
}

async function getfetch(lien) {
try {
const response = await fetch(lien);
const data = await response.json();
return data;
} catch (error) {
console.error('Error fetching data:', error);
throw error; 
}
}



function programFlight() {
const startAirport = document.getElementById('startAirport').value;
const finalAirport = document.getElementById('finalAirport').value;
const dateDepart = document.getElementById('dateDepart').value;
const dateArrive = document.getElementById('dateArrive').value;
const avion = document.getElementById('avion').value;
const parts = avion.split('_');

const id = parts[0];
console.log(id);
var airoprtDepart;
var airoprtArrive;

getfetch('http://localhost:8080/Airport').then(async (item) => {
item.map((air) => {
  if (air.idAeroport === parseInt(startAirport)) {
    airoprtDepart = air;
  }if (air.idAeroport === parseInt(finalAirport)) {
    airoprtArrive = air;
  }
});

const avion2 = await getfetch(`http://localhost:8080/avion/${id}`);

vol = {
  "aeroportDebut": airoprtDepart,
  "aeroportArrive": airoprtArrive,
  "dateDepart": new Date(dateDepart.toString()),
  "dateArrive": new Date(dateArrive.toString()),
  "avion": avion2,
  "problemes": [],
};
fetchPaths(vol);

});
}


async function fetchPaths(vol) {
const response = await fetch("http://localhost:8080/vol", {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify(vol),
});
}


funCall('http://localhost:8080/Airport');

function getConcatenatedName(avion) {
  return `${avion.id_avoin}_${avion.typeAvion}`;
}