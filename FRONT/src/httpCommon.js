import axios from "axios";

export default axios.create({

    baseURL:"jdbc:mysql://127.0.0.1/db_todo",
    headers: {
        "Content-type": "aplication/json"
    }

})