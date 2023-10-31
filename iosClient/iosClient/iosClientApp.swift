//
//  iosClientApp.swift
//  iosClient
//
//  Created by ariefmaffrudin on 24/10/23.
//

import SwiftUI
import shared

@main
struct iosClientApp: App {
    init() {
        InjectionKt.doInitKoin()
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
