import http from '../httpCommon';

export default({

    create(ProductData){
        return http.post(`/product`, ProductData);
    },

    getAll(params) {
        return http.get(`/product`, { params });
    },
      
    getById(productId) {
        return http.get(`/product/${productId}`);
    },
    
    update(productId, ProductData) {
        return http.put(`/product/update/${productId}`, ProductData);
    },
    
    delete(productId) {
        return http.delete(`/product/delete/${productId}`);
    }
});
