import {defineConfig} from "@playwright/test";

export default defineConfig({
  use: {
    baseURL: 'http://localhost:4200',
  },
  webServer: [
    {
      command: 'npm run start:ng',
      port: 4200,
      reuseExistingServer: !process.env['CI'],
    },
    {
      command: 'npm run start:server',
      port: 3000,
      reuseExistingServer: !process.env['CI'],
    },
  ],
});
