// JavaScript Document pour les fonctions ajax
function miseJourStyleClass(elem) {
	//Les tables ont une structure particulière dans le DOM.
	//Leur parcours est facilité grâce aux propriétés rows de l'élément de nom de balise table, qui permet d'avoir les lignes de la table dans un objet indexé
	//Chaque ligne a ensuite une propriété cells qui permet d'accéder aux cellules de cette ligne.
	var tr = document.getElementById(elem.id);
	for (var col=2 ; col<tr.cells.length ; col++){
		tr.cells[col].childNodes[0].className=tr.cells[col].childNodes[0].className+" bgTrav";
	}
}

function miseJourStyleClassEnseig(codeEnseig) {
	var arrayLignes = document.getElementById("bodytab").rows; //on récupère les lignes du tableau
	var visuOk = 'N';
	for (var i=0;i<arrayLignes.length;i++) {
		var tr = arrayLignes[i];
		if (tr.cells[0].childNodes[0].nodeType == 1) {
			if (tr.cells[0].childNodes[0].firstChild.nodeValue == codeEnseig)
				visuOk = 'O';
			else
				visuOk = 'N';
		}
		if (visuOk == 'O') {
			for (var col=2 ; col<tr.cells.length ; col++){
				tr.cells[col].childNodes[0].className=tr.cells[col].childNodes[0].className+" bgTrav";
			}
		}
	}
}

function simuClick() {
	var evt = document.createEvent("MouseEvents");
	evt.initMouseEvent("click", true, true, window,0, 0, 0, 0, 0, false, false, false, false, 0, null);
	document.getElementById("butclic").dispatchEvent(evt);
}