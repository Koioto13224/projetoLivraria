import axios from "axios";


export class BackendHttpClient {
  // http: AxiosInstance;

  constructor(baseUri) {
    this.http = axios.create({
      baseURL: baseUri,
      timeout: 30000,
      responseType: 'json',
    })

    this.http.interceptors.response.use(this.handleSucess, this.handleError);
  }

  async get(url, options) {
    return this.http.get(url, options).then(this.getData);
  }

  getResponse(url, options) {
    return this.http.get(url, options);
  }

  postResponse(url, data, options) {
    return this.http.post(url, data, options)
  }

  async post(url, data, options) {
    return this.http.post(url, data, options).then(this.getData);
  }

  createAuthHeader(token) {
    if (!token) {
      throw new Error("The provided token is null");
    }

    return {
      headers: {
        'Authorization': `Bearer ${token}`
      }
    }
  }

  handleSucess(response) {
    return response;
  }

  handleError(error) {
    if (error && error.response) {
      const { data } = error.response;
      if (!data) return Promise.reject(data);
    }
    return Promise.reject(error);
  }

  async getData(response) {
    return response.data;
  }

  async getBooks(config){
    return this.get("listarLivros", config)
  }
  
}

export default new BackendHttpClient("http://localhost:9090/")
