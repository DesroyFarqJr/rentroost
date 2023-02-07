import axios from 'axios';

export default {
    getAllProperties() {
        return axios.get('/property/');
    },
    searchProperties(bedrooms, bathrooms, minRent, maxRent) {
        console.log(`bedrooms ${bedrooms}, bathrooms ${bathrooms}, minRent ${minRent}, maxRent ${maxRent}`)
        let searchString = `/property/search`;
        if (bedrooms || bathrooms || minRent || maxRent) {
            searchString += '?'
        }
        if (bedrooms){
            searchString += `bedrooms=${bedrooms}`;
        }
        if (bathrooms) {
            if (bedrooms) {
                searchString += '&';
            }
            searchString += `bathrooms=${bathrooms}`;
        }
        if (minRent || minRent > 0 || minRent != null) {
            console.log(`minRent === ${minRent}`);
            if (bedrooms || bathrooms) {
                searchString += '&';
            }
            searchString += `minrent=${minRent}`;
        }
        if (maxRent || maxRent > 0 || maxRent != null) {
            console.log(`maxRent === ${maxRent}`);
            if (bedrooms || bathrooms || maxRent) {
                searchString += '&';
            }
            searchString += `maxrent=${maxRent}`;
        }
        console.log(`property searchstring = ${searchString}`);
        return axios.get(searchString);
    },
    addProperty(property) {
        console.log(property);
        return axios.post('/property/addproperty', property);
    },
    getProperty(id) {
        return axios.get('/property/' + id);
    },
    addMaintenanceRequest(request) {
        return axios.post('/newticket', request)
    }
}