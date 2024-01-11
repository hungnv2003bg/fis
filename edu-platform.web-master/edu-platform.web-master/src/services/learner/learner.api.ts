import axios from "axios";
import domain from "../../configs/server.config";

const http = axios.create({
  baseURL: domain.apiBaseUrl
});

export default http;