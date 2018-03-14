import Vue from 'vue';

const app = new Vue({
  el: '#app',
  data: {
    msg: 'hello!?',
    isOnline: true,
    query: '',
    isPowerSyntaxEnabled: false,
    searchIndices: [],
  },
  methods: {
    executeSearch(token, event) {
      const message = `Token: ${token} Query: ${this.query} Button: ${event.target.innerText}`;
      // eslint-disable-next-line
      alert(message);
    },
  },
});

export default { app };
