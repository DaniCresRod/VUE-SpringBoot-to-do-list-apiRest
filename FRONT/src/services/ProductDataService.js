import http from '../httpCommon';

export default({

    create(ProductData){
        return http.post(`/product`, ProductData);
    },

    getAll(ProductData) {
        return http.get(`/product`, ProductData);
    },
    
    getById(productId) {
        return http.get(`/product/${productId}`);
    },
    
    update(productId, ProductData) {
        return http.put(`/product/delete/${productId}`, ProductData);
    },
    
    delete(productId) {
        return http.delete(`/product/delete/${productId}`);
    }
});
