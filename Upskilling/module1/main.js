console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Community Portal Loaded Successfully");
});


const eventName = "Music Night";
const eventDate = "2025-07-15";

let availableSeats = 50;

console.log(`
Event Name : ${eventName}
Event Date : ${eventDate}
Seats Available : ${availableSeats}
`);

availableSeats--;
console.log("Seats after registration:", availableSeats);


class Event {

    constructor(id, name, category, location, seats, upcoming = true) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.seats = seats;
        this.upcoming = upcoming;
    }
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};


let events = [

    new Event(
        1,
        "Music Night",
        "Music",
        "Bhopal",
        20,
        true
    ),

    new Event(
        2,
        "Tech Conference",
        "Technology",
        "Indore",
        15,
        true
    ),

    new Event(
        3,
        "Old Event",
        "Music",
        "Delhi",
        0,
        false
    )
];

events.push(
    new Event(
        4,
        "Cooking Workshop",
        "Workshop",
        "Bhopal",
        10,
        true
    )
);

const musicEvents =
    events.filter(
        event => event.category === "Music"
    );

console.log("Music Events:", musicEvents);


const eventCards =
    events.map(
        event => `Workshop on ${event.name}`
    );

console.log(eventCards);


console.log("Valid Events:");

events.forEach(event => {

    if (event.upcoming && event.seats > 0) {

        console.log(event.name);

    } else {

        console.log(
            `${event.name} hidden`
        );
    }
});

function addEvent(eventObj) {

    events.push(eventObj);
}


function registerUser(eventId) {

    try {

        const event =
            events.find(
                e => e.id === eventId
            );

        if (!event) {
            throw new Error("Event Not Found");
        }

        if (event.seats <= 0) {
            throw new Error("No Seats Available");
        }

        event.seats--;

        console.log(
            `Registered for ${event.name}`
        );

    } catch (error) {

        console.error(error.message);
    }
}


function filterEventsByCategory(category) {

    return events.filter(
        event =>
        event.category === category
    );
}


function registrationTracker() {

    let totalRegistrations = 0;

    return function () {

        totalRegistrations++;

        return totalRegistrations;
    };
}

const trackRegistration =
    registrationTracker();

console.log(trackRegistration());
console.log(trackRegistration());


function searchEvents(callback) {

    return callback(events);
}

Object.entries(events[0])
      .forEach(([key, value]) => {

          console.log(
              `${key} : ${value}`
          );
      });


const container =
document.querySelector("#eventContainer");

function renderEvents(list = events) {

    if (!container) return;

    container.innerHTML = "";

    list.forEach(event => {

        const card =
        document.createElement("div");

        card.className = "event-card";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.category}</p>
            <p>Seats : ${event.seats}</p>

            <button
            onclick="registerUser(${event.id})">
            Register
            </button>
        `;

        container.appendChild(card);
    });
}

renderEvents();

const categoryFilter =
document.querySelector("#categoryFilter");

if (categoryFilter) {

    categoryFilter.onchange =
    function () {

        const filtered =
        this.value === "All"
        ? events
        : filterEventsByCategory(
            this.value
        );

        renderEvents(filtered);
    };
}

const searchInput =
document.querySelector("#searchBox");

if (searchInput) {

    searchInput.addEventListener(
        "keydown",
        () => {

            const keyword =
            searchInput.value
                .toLowerCase();

            const filtered =
            events.filter(event =>
                event.name
                     .toLowerCase()
                     .includes(keyword)
            );

            renderEvents(filtered);
        }
    );
}

fetch("events.json")
    .then(response =>
        response.json()
    )
    .then(data =>
        console.log(data)
    )
    .catch(error =>
        console.error(error)
    );



async function loadEvents() {

    try {

        console.log("Loading...");

        const response =
        await fetch("events.json");

        const data =
        await response.json();

        console.log(data);

    } catch (error) {

        console.error(error);
    }
}

loadEvents();

const {
    name,
    category
} = events[0];

console.log(name);
console.log(category);

const clonedEvents = [...events];

console.log(clonedEvents);

function greet(
    user = "Guest"
) {
    console.log(
        `Welcome ${user}`
    );
}

greet();


const form =
document.querySelector(
    "#registrationForm"
);

if (form) {

    form.addEventListener(
        "submit",
        function (event) {

            event.preventDefault();

            const name =
            form.elements.name?.value;

            const email =
            form.elements.email?.value;

            const selectedEvent =
            form.elements.selectedEvent?.value;

            if (!name || !email) {

                console.log(
                    "Please fill all fields"
                );

                return;
            }

            console.log(
                name,
                email,
                selectedEvent
            );
        }
    );
}

function submitRegistration() {

    const userData = {

        name: "John",
        email: "john@gmail.com"
    };

    setTimeout(() => {

        fetch(
            "https://jsonplaceholder.typicode.com/posts",
            {
                method: "POST",

                headers: {
                    "Content-Type":
                    "application/json"
                },

                body:
                JSON.stringify(
                    userData
                )
            }
        )
        .then(response =>
            response.json()
        )
        .then(data => {

            console.log(
                "Registration Success"
            );

            console.log(data);
        })
        .catch(error => {

            console.log(
                "Registration Failed"
            );

            console.error(error);
        });

    }, 2000);
}


console.log("Form Submitted");
console.log("Validating Inputs");
console.log("Sending API Request");
console.log("Response Received");


$("#registerBtn").click(function () {

    console.log("jQuery Button Clicked");

    $(".event-card").fadeOut(1000);

    setTimeout(() => {

        $(".event-card").fadeIn(1000);

    }, 1000);
});

console.log(
    "React and Vue provide reusable components, better state management and scalable UI development."
);