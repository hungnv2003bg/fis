import axios from "axios";
import domain from "../../configs/server.config";
import {setupRequest} from "../../utils/request";

const http = axios.create({
  baseURL: domain.apiBaseUrl
});

setupRequest(http);

export default http