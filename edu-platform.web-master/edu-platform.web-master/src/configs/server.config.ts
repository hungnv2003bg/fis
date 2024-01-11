const serverConfig = {
  dev: {
    // apiBaseUrl: 'https://api.clazzi.xyz'
    apiBaseUrl: 'http://localhost:8080'
  },
  test: {
    apiBaseUrl: 'https://api.clazzi.xyz'
  },
  prod: {
    apiBaseUrl: 'https://api.clazzi.xyz'
  }
};

const domain = serverConfig[process.env.REACT_APP_ENV || "dev"];
export default domain;