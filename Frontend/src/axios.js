import axios from "axios";

const http = axios.create(
    {baseURL: 'http://localhost:9091/'}
)

export default http;