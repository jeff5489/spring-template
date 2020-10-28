

document.querySelector("#getAllPeopleButton").addEventListener("click", 
    // getPerson()
async function(){
    const response = await fetch ('http://localhost:8080/spring-rest-template/api/people/')
    const people = await response.json()
    console.log(people)
}
)

// document.getElementById("getAllPeopleButton").addEventListener("click", 
//     getPerson()
// )

async function getPerson(){
    const response = await fetch ('http://localhost:8080/spring-rest-template/api/people/')
    const people = await response.json()
    console.log(people)
}