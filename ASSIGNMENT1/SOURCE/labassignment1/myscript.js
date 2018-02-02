function onSubmit() {
    var x = document.forms["demo"]["firstname"].value;
    var y = document.forms["demo"]["lastname"].value;
    if (x === "" && y === "") {
        alert("First Name and Last Name must be filled out");
        return false;
    }
    if (x === "") {
        alert("First Name must be filled out");
        return false;
    }
    if (y === "") {
        alert("Last Name must be filled out");
        return false;
    }
    var a = document.getElementById("deg");
    var text1 = a.options[a.selectedIndex].text;

    var s = document.getElementById("sem");
    var text2 = s.options[s.selectedIndex].text;

    var c = document.getElementById("car");
    var text3 = c.options[c.selectedIndex].text;

    if (text1 === "Masters") {
        if (text2 === "Spring 2018") {
            if (text3 === "Computer Science") {
                window.location.assign("http://localhost:63342/labassignment1/list1.html?_ijt=vkt72mnpeg24fhdobqhqrfqfom");
            }

        }
    }
    if (text1 === "Masters") {
        if (text2 === "Spring 2018") {
            if (text3 === "Electrical Engineering") {
                window.location.assign("http://localhost:63342/labassignment1/list2.html?_ijt=6n4gr9pmrcr3gus7515vnsgfsv");
            }

        }
    }
    if (text1 === "Bachelors") {
        if (text2 === "Fall 2018") {
            if (text3 === "Computer Science") {
                window.location.assign("http://localhost:63342/labassignment1/list3.html?_ijt=6n4gr9pmrcr3gus7515vnsgfsv");
            }

        }
    }
    if (text1 === "Bachelors") {
        if (text2 === "Fall 2018") {
            if (text3 === "Electrical Engineering") {
                window.location.assign("http://localhost:63342/labassignment1/list4.html?_ijt=6n4gr9pmrcr3gus7515vnsgfsv");
            }

        }
    }



    document.getElementById("demo").innerHTML = "Searching results for " + text1 + " students " + text2 + " semester in " + text3 + " career";



}
