<template>
    <div>
        {{ initialValue }}
    </div>
</template>

<script lang="ts">

import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class LocalComponent extends Vue {
    @Prop() public initialValue!: Number;
}

</script>