<script>
export default {
  data: () => ({
    links: [
      { name: 'Home', route: '/' },
      { name: 'Team', route: '/team' },
      { name: 'Services', route: '/services' },
      { name: 'Contact Us', route: '/contact' },
    ],
  }),
};
</script>

<template>
  <v-footer class="bg-grey-lighten-1">
    <v-row justify="center" no-gutters>
      <router-link
        v-for="link in links"
        :key="link.name"
        :to="link.route"
        variant="text"
        color="white"
        class="mx-2 links"
        rounded="x0.5"
      >
        {{ link.name }}
      </router-link>
      <v-col class="text-center mt-4 footerText" cols="12">
        {{ new Date().getFullYear() }} — <strong>ToDs List</strong>
      </v-col>
    </v-row>
  </v-footer>
</template>

<style scoped>
footer {
  max-height: 200px;
}
.links {
  color: white;
  text-decoration: none;
}
.footerText{
  color: rgba(54, 157, 178, 1);
}
</style>
