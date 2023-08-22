<template>
    <div>
    <div v-if="error">Error: {{ error.message }}</div>
    <div v-else-if="isLoading">Loading...</div>
    <div v-else>
        <div v-for="products in data" :key="product.id">{{ product.name }}</div>
    </div>
    </div>
</template>
  
<script>
import { ref, onMounted } from "vue";
import useFetch from "../components/hooks/useFetch";
import DynamicUrl from "../components/services/DynamicUrl";

export default {
    setup() {
    const data = ref(null);
    const error = ref(null);
    const isLoading = ref(true);

    onMounted(() => {
        fetch(`${DynamicUrl}/XXXXX`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(apiData => {
            data.value = apiData;
            isLoading.value = false;
        })
        .catch(err => {
            error.value = err;
            isLoading.value = false;
        });
    });

    return { data, error, isLoading };
    },
};
</script>
