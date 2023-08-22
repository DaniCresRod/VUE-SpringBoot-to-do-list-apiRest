import { ref, onMounted } from "vue";

const useFetch = (dynamicUrl) => {
  const data = ref([]);
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

export default useFetch;
