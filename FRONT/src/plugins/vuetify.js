import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'

export default createVuetify({
  theme: {
    themes: {
      light: {
        colors: {
          primary: 'rgba(54, 157, 178, 1)',
          secondary: '#5CBBF6',
        },
      },
    },
  },
})
