import { ref } from "vue";

const useFetch = async (dynamicUrl) => {
  const data = ref(null);
  const error = ref(null);
  const isLoading = ref(true);

  try {
    const response = await fetch(dynamicUrl);
    if (!response.ok) {
      throw new Error("La red no funciona, pi pi pi");
    }
    const json = await response.json();
    data.value = json;
  } catch (error) {
    console.error("error trayendonos los datos:", error);
    error.value = error;
  } finally {
    isLoading.value = false;
  }

  return { data, error, isLoading };
};

export default useFetch;


