//
//  Dialog.swift
//  iosApp
//
//  Created by Daan Klarenbeek on 10/12/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Presentation
import SwiftUI

struct DialogView: View {
    var title: String
    var description: String?
    var actions: [DialogAction]

    var body: some View {
        let message = description == nil ? nil : Text(description!)

        Text("")
            .alert(
                title,
                isPresented: .constant(true),
            ) {
                ForEach(actions, id: \.name) { action in
                    let role = getButtonRole(type: action.type)
                    Button(action.name, role: role) {
                        action.action()
                    }
                }
            } message: {
                message
            }
    }

    func getButtonRole(type: DialogActionType) -> ButtonRole? {
        switch type {
        case DialogActionType.dismiss:
            return ButtonRole.cancel
        case DialogActionType.destructive:
            return ButtonRole.destructive
        case DialogActionType.submit:
            return nil
        default:
            return nil
        }
    }
}
