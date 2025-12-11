//
//  ViewFactory.swift
//  iosApp
//
//  Created by Daan Klarenbeek on 10/12/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Presentation
import SwiftUI

class ViewFactory: NativeViewFactory {
    func dialogFactory(title: String, description: String?, actions: [DialogAction]) -> UIViewController {
        let dialogView = DialogView(title: title, description: description, actions: actions)
        let controller = UIHostingController(rootView: dialogView)
        controller.view.backgroundColor = .clear

        return controller
    }
}
