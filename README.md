# SET News Alert (Android test)

This is the **free, local notification test**. It is not yet connected to live economic calendar data, Firebase, or a push backend.

## Build APK on GitHub
1. Upload the **contents** of this directory into the repository root, preserving `.github/workflows/build-apk.yml`.
2. Open **Actions** > **Build Android APK** > **Run workflow**, or push to main.
3. After the build succeeds, open its run > **Artifacts** > download `SET-News-Alert-debug-APK`.
4. Unzip the downloaded artifact to get `app-debug.apk`, then install it on Android.
5. Open the app and tap the 20-second notification test button. Keep the app open for this test.

The APK is a debug build for testing only. Android may warn about installing outside Play Store. Do not upload secrets or Firebase service-account credentials to a public repository.

## Next stages
- Verify notification behavior on Honor.
- Add an economic-calendar data source with explicit licensing and cost checks.
- Add a secure backend and Firebase Cloud Messaging, subject to user approval of any billing requirement.
