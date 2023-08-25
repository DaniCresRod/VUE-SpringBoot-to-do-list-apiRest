import axiosConnection from '../httpCommon';

export default({

    create(ProductData){
        return axiosConnection.post(`/login/logo`, ProductData);
    }
})

