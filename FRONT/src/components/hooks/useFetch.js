import { ref, onMounted } from "vue";

const useFetch = (dynamicUrl) => {
  const data = ref([null]);
  const error = ref(null);
  const isLoading = ref(true);
  const fetchData = async () => {
    try {
      const response = await fetch(dynamicUrl);
      const json = await response.json();
      data.value = json;
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  onMounted(fetchData);

  return data;
};
// export default {
//     setup() {
//     const data = ref(null);
    

//     onMounted(() => {
//         fetch(`${DynamicUrl}/goods`)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error("Network response was not ok");
//             }
//             return response.json();
//         })
//         .then(apiData => {
//             data.value = apiData;
//             isLoading.value = false;
//         })
//         .catch(err => {
//             error.value = err;
//             isLoading.value = false;
//         });
//     });

//     return { data, error, isLoading };
//     },
// };


export default useFetch;
