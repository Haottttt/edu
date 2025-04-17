<template>
  <div>
    <h2>系统通知</h2>
    <ul>
      <li v-for="n in $store.state.notifications" :key="n.id">
        {{ n.text }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {}
</script>
