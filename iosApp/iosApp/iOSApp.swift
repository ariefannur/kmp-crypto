import SwiftUI
import shared

@main
struct iOSApp: App {
        
    init() {
        InjectionKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
