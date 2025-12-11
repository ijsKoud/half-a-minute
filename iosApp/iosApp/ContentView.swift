import Presentation
import SwiftUI
import UIKit

struct ComposeView: UIViewControllerRepresentable {
    static var viewFactory = ViewFactory()
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(viewFactory: ComposeView.viewFactory)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.all)
    }
}
