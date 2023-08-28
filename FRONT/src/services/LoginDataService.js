import axiosConnection from '../httpCommon';

export default({

    create(ProductData){
        return axiosConnection.post(`/login/logo`, ProductData);
    },

    signUp(ProductData){
        return axiosConnection.post('/login/add', ProductData);
    }
})

